// Produtos
const produtos = [
  { id: 1, nome: "Minecraft", preco: 99.00, genero: "Survival", img: "Images/Minecraft.png" },
  { id: 2, nome: "The Legend of Zelda™: Tears of the Kingdom", preco: 499.90, genero: "Aventura", img: "Images/tearsofthekingdom.avif" },
  { id: 3, nome: "Super Mario Odyssey", preco: 249.90, genero: "Plataforma", img: "Images/mario-odyssey.avif" },
  { id: 4, nome: "FIFA 25", preco: 299.00, genero: "Esporte", img: "Images/fifa25.jpg" },
  { id: 5, nome: "God of War", preco: 199.90, genero: "Ação", img: "Images/god2018.jpg" },
  { id: 6, nome: "Final Fantasy XVI", preco: 219.90, genero: "RPG", img: "Images/ffxvi.jpg" }
];

// Carrinho
let carrinho = [];

// Elementos
const containerProdutos = document.getElementById("containerProdutos");
const botaoCarrinho = document.getElementById("botaoCarrinho");
const modalCarrinho = document.getElementById("modalCarrinho");
const botaoFecharCarrinho = document.getElementById("botaoFecharCarrinho");

const contadorCarrinho = document.getElementById("contadorCarrinho");
const listaCarrinho = document.getElementById("listaCarrinho");
const totalCarrinho = document.getElementById("totalCarrinho");

const botaoLimparCarrinho = document.getElementById("botaoLimparCarrinho");
const botaoPagamento = document.getElementById("botaoPagamento");

const barraPesquisa = document.getElementById("barraPesquisa");
const filtroGenero = document.getElementById("filtroGenero");
const botaoModo = document.getElementById("botaoModo");

// Toasts
const toastItemEscolhido = document.getElementById("toastItemEscolhido");
const toastCarrinho = document.getElementById("toastCarrinho");
const toastRemover = document.getElementById("toastRemover");
const toastFinalizar = document.getElementById("toastFinalizar");
const toastNenhumJogo = document.getElementById("toastNenhumJogo");

// Renderizar produtos
function renderizarProdutos(lista){
  containerProdutos.innerHTML = "";
  lista.forEach((p,index)=>{
    const div = document.createElement("div");
    div.className="product";
    div.style.animationDelay=`${index*0.1}s`;
    div.innerHTML=`
      <img src="${p.img}" alt="${p.nome}">
      <h3>${p.nome}</h3>
      <p>Gênero: ${p.genero}</p>
      <p><strong>R$ ${p.preco.toFixed(2)}</strong></p>
      <button onclick="adicionarAoCarrinho(${p.id})">Adicionar ao Carrinho</button>
    `;
    containerProdutos.appendChild(div);
  });
}
renderizarProdutos(produtos);

// Mostrar toast
function mostrarToast(toast){
  toast.classList.add("show");
  setTimeout(()=>toast.classList.remove("show"),2000);
}

// Carrinho
function adicionarAoCarrinho(id){
  const item = produtos.find(p=>p.id===id);
  carrinho.push(item);
  atualizarCarrinho();
  mostrarToast(toastItemEscolhido);
  botaoCarrinho.classList.add("tremer");
  setTimeout(()=>botaoCarrinho.classList.remove("tremer"),500);
}

function removerDoCarrinho(index){
  carrinho.splice(index,1);
  atualizarCarrinho();
  mostrarToast(toastRemover);
}

function atualizarCarrinho(){
  contadorCarrinho.textContent=carrinho.length;
  listaCarrinho.innerHTML="";
  let total=0;
  carrinho.forEach((item,index)=>{
    total+=item.preco;
    const li=document.createElement("li");
    li.className="carrinho-item";
    li.innerHTML=`
      <img src="${item.img}" alt="${item.nome}" class="carrinho-img">
      <div class="carrinho-info">
        <span class="carrinho-nome">${item.nome}</span>
        <div class="carrinho-preco-container">
          <span class="carrinho-preco">R$ ${item.preco.toFixed(2)}</span>
          <button onclick="removerDoCarrinho(${index})" class="remover-item">❌</button>
        </div>
      </div>
    `;
    listaCarrinho.appendChild(li);
  });
  totalCarrinho.textContent=total.toFixed(2);
}

// Limpar carrinho
botaoLimparCarrinho.addEventListener("click",()=>{
  if(carrinho.length===0){
    toastCarrinho.textContent="🛒 Carrinho já está vazio!";
    mostrarToast(toastCarrinho);
  }else{
    carrinho=[];
    atualizarCarrinho();
    toastCarrinho.textContent="🛒 Carrinho limpo!";
    mostrarToast(toastCarrinho);
  }
});

// Finalizar compra
botaoPagamento.addEventListener("click",()=>{
  if(carrinho.length===0){
    toastCarrinho.textContent="🛒 Carrinho vazio!";
    mostrarToast(toastCarrinho);
    return;
  }
  mostrarToast(toastFinalizar);
  carrinho=[];
  atualizarCarrinho();
  alternarCarrinho();
});

// Abrir/fechar carrinho
botaoCarrinho.addEventListener("click",alternarCarrinho);
botaoFecharCarrinho.addEventListener("click",alternarCarrinho);
function alternarCarrinho(){
  modalCarrinho.classList.toggle("show");
}

// Filtro de gênero
filtroGenero.addEventListener("change",()=>{
  const valor=filtroGenero.value;
  if(valor==="") renderizarProdutos(produtos);
  else renderizarProdutos(produtos.filter(p=>p.genero===valor));
});

// Pesquisa
let timeoutPesquisa;
barraPesquisa.addEventListener("input",()=>{
  clearTimeout(timeoutPesquisa);
  timeoutPesquisa=setTimeout(()=>{
    const valor=barraPesquisa.value.toLowerCase();
    const filtrados=produtos.filter(p=>p.nome.toLowerCase().includes(valor));
    renderizarProdutos(filtrados);
    if(filtrados.length===0 && valor.trim()!=="") mostrarToast(toastNenhumJogo);
  },800);
});

// Modo escuro
botaoModo.addEventListener("click",()=>{
  document.body.classList.toggle("dark");
  botaoModo.textContent=document.body.classList.contains("dark")?"☀️":"🌙";
});
