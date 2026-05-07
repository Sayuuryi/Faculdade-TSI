async function login(){
 const email = document.getElementById("email").value;
 const senha = document.getElementById("senha").value;

 const res = await fetch("/login", {
  method:"POST",
  headers: {"Content-Type":"application/json"},
  body: JSON.stringify({email, senha})
 });

 const data = await res.json();

 if(data.ok){
  window.location.href="dashboard.html";
 } else {
  alert("Login inválido");
 }
}

async function logout(){
 await fetch("/logout");
 window.location.href="login.html";
}

// PROTEÇÃO
async function checkAuth(){
 const res = await fetch("/user");
 const user = await res.json();
 if(!user){
  window.location.href="login.html";
 }
}

async function criarChamado(){
 const inputTitulo = document.getElementById("novo-titulo").value;
 const inputDescricao = document.getElementById("novo-descricao").value;
 const inputPrioridade = document.getElementById("novo-prioridade").value;

 await fetch("/chamados", {
  method:"POST",
  headers: {"Content-Type":"application/json"},
  body: JSON.stringify({
   titulo: inputTitulo,
   descricao: inputDescricao,
   prioridade: inputPrioridade
  })
 });

 fecharModalNovo();
 loadChamados();
}

async function loadChamados(){
 // Checa o usuário ativo para saber se é admin
 const resUser = await fetch("/user");
 const user = await resUser.json();
 const isAdmin = user && user.tipo === "admin";
 window.usuarioAtual = user;

 // Mostra abas exclusivas para admin (já estão ocultas no HTML por padrão para evitar piscar na tela)
 if (isAdmin) {
  const navAdmin = document.getElementById("nav-admin");
  if (navAdmin) navAdmin.style.display = "flex";
 } else {
  const navAdmin = document.getElementById("nav-admin");
  if (navAdmin) navAdmin.style.display = "none";
 }

 const res = await fetch("/chamados");
 const lista = await res.json();
 window.chamadosAtuais = lista;

 const total = document.getElementById("total");
 const andamento = document.getElementById("andamento");
 const resolvido = document.getElementById("resolvido");

 total.innerText = lista.length;
 andamento.innerText = lista.filter(c=>c.status==="Em andamento").length;
 resolvido.innerText = lista.filter(c=>c.status==="Resolvido").length;

 let html = "";

 lista
 .filter(c => !isAdmin || c.status !== "Resolvido") // Mostra resolvidos para o usuário, mas esconde do admin (ele já tem aba própria)
 .forEach(c=>{
  
  let btnAcao = "";
  if (!isAdmin) {
    btnAcao = `<button onclick="abrirModal(${c.id})" class="bg-blue-500 text-white px-3 py-1 rounded text-sm hover:bg-blue-600 transition">Visualizar / Chat</button>`;
  }

  html += `<tr>
    <td class="p-2">${c.titulo}</td>
    <td>${c.status}</td>
    <td>${c.prioridade}</td>
    <td>${btnAcao}</td>
  </tr>`;
 });

 document.getElementById("lista").innerHTML = html;

 document.getElementById("th-acoes").innerText = isAdmin ? "" : "Ações";
}

async function setStatus(id, status){
 await fetch("/status", {
  method:"POST",
  headers: {"Content-Type":"application/json"},
  body: JSON.stringify({id, status})
 });

 loadChamados();
}

// ==============================
// GERENCIAMENTO DO MODAL (ADMIN)
// ==============================
let chamadoAtualId = null;

function abrirModal(id) {
 chamadoAtualId = id;
 
 const c = window.chamadosAtuais.find(x => Number(x.id) === Number(id));
 if (!c) return;
 
 document.getElementById("modal-titulo").innerText = c.titulo;
 document.getElementById("modal-autor").innerText = c.autor || 'Desconhecido';
 document.getElementById("modal-prioridade").innerText = c.prioridade;
 document.getElementById("modal-status").innerText = c.status;
 document.getElementById("modal-descricao").innerText = c.descricao || 'Sem descrição.';
 
 const isAdmin = window.usuarioAtual && window.usuarioAtual.tipo === "admin";
 if (isAdmin) {
   document.getElementById("admin-status-div").classList.remove("hidden");
   document.getElementById("admin-acoes-div").classList.remove("hidden");
   document.getElementById("modal-select-status").value = c.status;
 } else {
   document.getElementById("admin-status-div").classList.add("hidden");
   document.getElementById("admin-acoes-div").classList.add("hidden");
 }

 // Oculta a área de digitação se o chamado estiver resolvido
 const chatInputArea = document.getElementById("chat-input-area");
 if (chatInputArea) {
   if (c.status === "Resolvido") {
     chatInputArea.classList.add("hidden");
   } else {
     chatInputArea.classList.remove("hidden");
   }
 }

 renderChat(c.mensagens || []);
 document.getElementById("modal-chamado").classList.remove("hidden"); // Remove o "hidden" para mostrar a tela
}

function renderChat(mensagens) {
 const chatDiv = document.getElementById("chat-mensagens");
 chatDiv.innerHTML = "";
 mensagens.forEach(m => {
  const isMe = window.usuarioAtual && m.autor === window.usuarioAtual.email;
  const alinhamento = isMe ? "text-right" : "text-left";
  const cor = isMe ? "bg-blue-100 text-blue-900" : "bg-white text-gray-900 border";
  chatDiv.innerHTML += `
   <div class="mb-2 ${alinhamento}">
    <div class="inline-block p-2 rounded-lg text-sm ${cor} max-w-[85%] text-left shadow-sm">
     <strong class="block text-xs text-gray-500 mb-1">${m.autor}</strong>
     ${m.texto}
    </div>
   </div>`;
 });
 chatDiv.scrollTop = chatDiv.scrollHeight;
}

function fecharModal() {
 document.getElementById("modal-chamado").classList.add("hidden"); // Adiciona o "hidden" de volta
 chamadoAtualId = null;
}

async function salvarStatus() {
 if (!chamadoAtualId) return;
 const novoStatus = document.getElementById("modal-select-status").value;
 await setStatus(chamadoAtualId, novoStatus);
 fecharModal();
}

async function enviarMensagem() {
 if (!chamadoAtualId) return;
 const input = document.getElementById("chat-input");
 const texto = input.value.trim();
 if (!texto) return;
 
 await fetch("/mensagem", {
  method: "POST",
  headers: {"Content-Type": "application/json"},
  body: JSON.stringify({ id: chamadoAtualId, texto })
 });
 
 input.value = "";
 if (window.location.pathname.includes("admin.html") && typeof loadAdmin === "function") {
  await loadAdmin();
 } else {
  await loadChamados();
 }
 abrirModal(chamadoAtualId);
}

function abrirModalNovo() {
 document.getElementById("modal-novo-chamado").classList.remove("hidden");
}

function fecharModalNovo() {
 document.getElementById("modal-novo-chamado").classList.add("hidden");
 document.getElementById("novo-titulo").value = "";
 document.getElementById("novo-descricao").value = "";
}

async function checkAdmin(){
 const res = await fetch("/user");
 const user = await res.json();

 if(!user || user.tipo !== "admin"){
   alert("Acesso negado");
   window.location.href = "dashboard.html";
 }
}