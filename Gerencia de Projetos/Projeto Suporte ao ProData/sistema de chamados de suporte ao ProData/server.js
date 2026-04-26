const express = require("express");
const session = require("express-session");
const fs = require("fs").promises; // Usando a versão assíncrona do File System

const app = express();

// CONFIG
app.use(express.static("public"));
app.use(express.json());

app.use(session({
    secret: "hospital",
    resave: false,
    saveUninitialized: true
}));

// ======================
// MIDDLEWARE DE AUTENTICAÇÃO
// ======================
const autenticar = (req, res, next) => {
    if (req.session.user) {
        return next();
    }
    return res.status(401).json({ ok: false, msg: "Acesso não autorizado." });
};

// ======================
// ROTA RAIZ (Redirecionamento)
// ======================
app.get("/", (req, res) => {
    res.redirect("/login.html");
});

// ======================
// LOGIN
// ======================
app.post("/login", (req, res) => {
    const { email, senha } = req.body;

    if(email === "admin@prodata.com" && senha === "admin123"){
        req.session.user = { email, tipo: "admin" };
        return res.json({ ok: true });
    }

    if(email && senha){
        req.session.user = { email, tipo: "user" };
        return res.json({ ok: true });
    }

    res.json({ ok: false });
});

// ======================
// USER
// ======================
app.get("/user", (req, res) => {
    res.json(req.session.user || null);
});

// ======================
// LOGOUT
// ======================
app.get("/logout", (req, res) => {
    req.session.destroy();
    res.json({ ok: true });
});

// ======================
// LISTAR CHAMADOS
// ======================
app.get("/chamados", autenticar, async (req, res) => {
    try {
        const data = await fs.readFile("db.json", "utf8");
        const db = JSON.parse(data);
        let chamados = db.chamados;
        // Se não for admin, vê apenas os próprios chamados
        if (req.session.user.tipo !== "admin") {
            chamados = chamados.filter(c => c.autor === req.session.user.email);
        }
        res.json(chamados);
    } catch (error) {
        res.status(500).json({ ok: false, msg: "Erro ao ler os chamados." });
    }
});

// ======================
// CRIAR CHAMADO
// ======================
app.post("/chamados", autenticar, async (req, res) => {
    try {
        const data = await fs.readFile("db.json", "utf8");
        const db = JSON.parse(data);

        const novoChamado = {
            id: Date.now(),
            autor: req.session.user.email,
            titulo: req.body.titulo,
            descricao: req.body.descricao || "Sem descrição",
            prioridade: req.body.prioridade,
            status: "Aberto",
            mensagens: []
        };

        db.chamados.push(novoChamado);

        await fs.writeFile("db.json", JSON.stringify(db, null, 2));

        res.json({ ok: true });
    } catch (error) {
        res.status(500).json({ ok: false, msg: "Erro ao criar chamado." });
    }
});

// ======================
// ENVIAR MENSAGEM
// ======================
app.post("/mensagem", autenticar, async (req, res) => {
    try {
        const data = await fs.readFile("db.json", "utf8");
        const db = JSON.parse(data);

        const chamado = db.chamados.find(c => Number(c.id) === Number(req.body.id));

        if(chamado){
            if (!chamado.mensagens) chamado.mensagens = [];
            chamado.mensagens.push({ autor: req.session.user.email, texto: req.body.texto, data: new Date().toISOString() });
        }

        await fs.writeFile("db.json", JSON.stringify(db, null, 2));

        res.json({ ok: true });
    } catch (error) {
        res.status(500).json({ ok: false, msg: "Erro ao enviar mensagem." });
    }
});

// ======================
// ALTERAR STATUS
// ======================
app.post("/status", autenticar, async (req, res) => {
    try {
        const data = await fs.readFile("db.json", "utf8");
        const db = JSON.parse(data);

        const chamado = db.chamados.find(c => Number(c.id) === Number(req.body.id));

        if(chamado){
            chamado.status = req.body.status;
        }

        await fs.writeFile("db.json", JSON.stringify(db, null, 2));

        res.json({ ok: true });
    } catch (error) {
        res.status(500).json({ ok: false, msg: "Erro ao atualizar status." });
    }
});

// ======================
// DELETAR CHAMADO (CORRIGIDO)
// ======================
app.post("/delete", autenticar, async (req, res) => {
    try {
        console.log("Deletando ID:", req.body.id);

        const data = await fs.readFile("db.json", "utf8");
        const db = JSON.parse(data);

        db.chamados = db.chamados.filter(
            c => Number(c.id) !== Number(req.body.id)
        );

        await fs.writeFile("db.json", JSON.stringify(db, null, 2));

        res.json({ ok: true });
    } catch (error) {
        res.status(500).json({ ok: false, msg: "Erro ao deletar chamado." });
    }
});

// ======================
app.listen(3000, () => {
    console.log("Servidor rodando em http://localhost:3000");
});