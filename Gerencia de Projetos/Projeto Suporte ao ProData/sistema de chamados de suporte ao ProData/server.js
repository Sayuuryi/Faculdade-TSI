const express = require("express");
const session = require("express-session");
const fs = require("fs");

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
app.get("/chamados", (req, res) => {
    const db = JSON.parse(fs.readFileSync("db.json"));
    res.json(db.chamados);
});

// ======================
// CRIAR CHAMADO
// ======================
app.post("/chamados", (req, res) => {
    const db = JSON.parse(fs.readFileSync("db.json"));

    const novoChamado = {
        id: Date.now(),
        titulo: req.body.titulo,
        prioridade: req.body.prioridade,
        status: "Aberto"
    };

    db.chamados.push(novoChamado);

    fs.writeFileSync("db.json", JSON.stringify(db, null, 2));

    res.json({ ok: true });
});

// ======================
// ALTERAR STATUS
// ======================
app.post("/status", (req, res) => {
    const db = JSON.parse(fs.readFileSync("db.json"));

    const chamado = db.chamados.find(c => Number(c.id) === Number(req.body.id));

    if(chamado){
        chamado.status = req.body.status;
    }

    fs.writeFileSync("db.json", JSON.stringify(db, null, 2));

    res.json({ ok: true });
});

// ======================
// DELETAR CHAMADO (CORRIGIDO)
// ======================
app.post("/delete", (req, res) => {

    console.log("Deletando ID:", req.body.id);

    const db = JSON.parse(fs.readFileSync("db.json"));

    db.chamados = db.chamados.filter(
        c => Number(c.id) !== Number(req.body.id)
    );

    fs.writeFileSync("db.json", JSON.stringify(db, null, 2));

    res.json({ ok: true });
});

// ======================
app.listen(3000, () => {
    console.log("Servidor rodando em http://localhost:3000");
});