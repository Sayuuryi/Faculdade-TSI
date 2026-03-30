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
  location="dashboard.html";
 } else {
  alert("Login inválido");
 }
}

async function logout(){
 await fetch("/logout");
 location="login.html";
}

// PROTEÇÃO
async function checkAuth(){
 const res = await fetch("/user");
 const user = await res.json();
 if(!user){
  location="login.html";
 }
}

async function criar(){
 await fetch("/chamados", {
  method:"POST",
  headers: {"Content-Type":"application/json"},
  body: JSON.stringify({
   titulo:titulo.value,
   prioridade:prioridade.value
  })
 });

 location="dashboard.html";
}

async function loadChamados(){

 const res = await fetch("/chamados");
 const lista = await res.json();

 total.innerText = lista.length;
 andamento.innerText = lista.filter(c=>c.status==="Em andamento").length;
 resolvido.innerText = lista.filter(c=>c.status==="Resolvido").length;

 let html = "";

 lista
 .filter(c => c.status !== "Resolvido")
 .forEach(c=>{

  html += `<tr>
    <td>${c.titulo}</td>
    <td>${c.status}</td>
    <td>${c.prioridade}</td>
  </tr>`;
 });

 document.getElementById("lista").innerHTML = html;
}

async function setStatus(id, status){
 await fetch("/status", {
  method:"POST",
  headers: {"Content-Type":"application/json"},
  body: JSON.stringify({id, status})
 });

 loadChamados();
}

async function checkAdmin(){
 const res = await fetch("/user");
 const user = await res.json();

 if(!user || user.tipo !== "admin"){
   alert("Acesso negado");
   window.location = "dashboard.html";
 }
}