
🌱 Fazendinha Bus Farm - Simulação de Fazenda 🐄🌾
-----------------------------------------------------------------------------------------------------------------------------------------------------------------
📖 Descrição
Fazendinha é um projeto de simulação de fazenda onde o jogador pode plantar, colher, criar animais e gerenciar os recursos da propriedade rural.
O objetivo é administrar os recursos da fazenda de forma eficiente, cultivando diferentes tipos de plantações, cuidando dos animais e vendendo produtos para lucrar e expandir a propriedade.

----------------------------------------------------------------------------------------------------------------------------------------------------------------
🚀 Funcionalidades principais
📋 Inventário de Itens
 Controle de sementes, produtos colhidos, animais, lotes, dinheiro e outros recursos.

🌱 Cultivo de Plantas e 🐄 Criação de Animais
 Plante e colha produtos como milho, soja e trigo e crie animais como galinhas, vacas e ovelhas.

💾 Salvamento e carregamento de jogo
 Cria arquivos para salvar o progresso do jogo e acessá-lo depois.

🛒 Sistema de Loja
 Compre e venda produtos, sementes e animais.

⏳ Simulação de Tempo
 O tempo avança em dias, afetando o crescimento das plantações e o ciclo dos animais.

🎲 Eventos Aleatórios
 Eventos inesperados como nascimento de animais ou bônus de dinheiro.

--------------------------------------------------------------------------------------------------------------------------------------------------------------

🛠️ Tecnologias utilizadas
Linguagem: Java 

Paradigmas: Programação orientada a objetos

Estruturas de Dados:  Mapas e vetores

IDE: IntelliJ IDEA 

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

📥 Instalação e execução
Clone o repositório:
git clone https://github.com/Giulia1955/Farming/tree/main

Compile o projeto:
javac TrabalhoFinalPOO/*.java

Execute o programa:
java Fazenda.Main

------------------------------------------------------------------------------------------------------------------------------------------------------

📌 Estrutura de Pastas
TrabalhoFinalPOO/
├── out/                          → Arquivos compilados
│   └── production/TrabalhoFinalPOO/Fazenda/
│       ├── Animais/              → Classes compiladas dos animais (Galinha, Ovelha, Vaca)
│       ├── Itens/                → Itens como ovos, leite, lã, sementes e filhotes
│       ├── Plantas/              → Plantas cultiváveis (Milho, Soja, Trigo)
│       ├── AppFazenda.class      → Classe principal compilada
│       ├── Controle.class        → Controle de fluxo do jogo
│       ├── EventoRandomico.class → Eventos inesperados na fazenda
│       └── Outros arquivos .class relacionados
├── src/                          → Código-fonte (.java)
│   └── Fazenda/
│       ├── Animais/              → Código fonte dos animais
│       ├── Itens/                → Código fonte dos itens
│       ├── Plantas/              → Código fonte das plantas
│       ├── Arquivo.java          → Manipulação de arquivos
│       ├── Ativo.java            → Interface/base de ativos
│       ├── AppFazenda.java       → Classe principal (Main)
│       ├── Controle.java         → Controle das interações
│       ├── EventoRandomico.java  → Classe para gerar eventos aleatórios
│       ├── Inventario.java       → Gestão de inventário
│       ├── Loja.java             → Sistema de loja
│       ├── Lotes.java            → Controle de lotes
│       ├── Produto.java          → Definição dos produtos
│       ├── TipoLote.java         → Enum ou classe com tipos de lotes
│       ├── AtualizarDiario.java  → Registro de ações no diário
│       ├── CartaIntroducao.java  → Introdução narrativa ao jogo
│       ├── Escolhas.java         → Classe com as escolhas de ações
│       └── ExibirResumo.java     → Exibição de resumo das atividades
├── TrabalhoFinalPOO.iml          → Arquivo de configuração do IntelliJ IDEA
└── Versao2.0.iml                 → Versão alternativa de configuração do projeto

---------------------------------------------------------------------------------------------------------------------------------------------------------------------

✅ Conceitos Aplicados
O projeto utiliza diversos conceitos da Programação Orientada a Objetos (POO), incluindo:
- Classes e Objetos: Estruturação de diferentes entidades como Loja, Inventario, Dinheiro, Produto, etc.
- Herança: Utilizada na hierarquia de Plantas, Animais e Itens.
- Polimorfismo: Métodos que se comportam de formas diferentes dependendo do objeto em questão.
- Encapsulamento: Controle de acesso através de modificadores (private, public, protected).
- Abstração: Representação de entidades genéricas (ex: Ativo, Produto).
- Coleções e Estruturas de Dados: Uso de vetores, mapas e outras coleções para controle de inventário e eventos.
- Leitura e Escrita em Arquivos: Classe `Arquivo` responsável por persistência de dados.
- Tratamento de Exceções: Várias classes que implementam detecções de erros com o try/catch.
- Uso do javadoc: implementação das descrições dos funcionamentos de cada classe.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------

🎨 Detalhamento Item Criativo
A cada dia dentro do jogo, eventos aleatórios podem ocorrer, como animais prenhes, sementes perdidas e empréstimos inesperados. Esses eventos são implementados através da classe EventoRandomico, que é responsável por sortear e aplicar os efeitos dos eventos aleatórios.
	Além disso, é feito um controle de todos os acontecimentos da fazenda, como o tempo de produção de todos os ativos, tempo de vida dos animais, a vida dos ativos dependerem dos cuidados do usuário, entre outras funcionalidades.
O objetivo das classes de Controle e EventoRandomico é deixar o jogo mais dinâmico e imprevisível, criando desafios e oportunidades que exigem do jogador planejamento e tomada de decisão e evitar que o jogo se torne monótono e repetitivo.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------

📈Sugestões de Melhorias
-Expansão do uso de itens criados, para utilização de novos itens (exemplo: usar lã para fazer casacos, leite para fazer queijo);

-Criação de uma tabela de estatísticas do jogo;

-Sistema de missões e conquistas para realizar;

-Clima dinâmico que afete o funcionamento dos ativos e eventos da fazenda.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

✨ Autores

Nome: Giulia Mezaroba
Contato: giuliamezaroba@gmail.com
GitHub: https://github.com/Giulia1955


Nome: Eduardo Barbero Bizzi Rodrigues
Contato: eduardobizzi10@gmail.com
GitHub: https://github.com/EduardoBizzi


Nome: Guilherme Roberto Nedochetko
Contato: guilhermenedochetko@gmail.com
GitHub:https://github.com/Flobster23

------------------------------------------------------------------------------------------------------------------------------------------------------------------------
