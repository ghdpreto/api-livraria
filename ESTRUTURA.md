ghdpreto/
└── apilivraria/
    ├── pom.xml
    └── src
        ├── main
        │   ├── java
        │   │   └── com
        │   │       └── ghdpreto
        │   │           └── apilivraria
        │   │               ├── ApiLivrariaApplication.java
        │   │               ├── common
        │   │               │   └── config
        │   │               │       └── SpringConfig.java
        │   │               ├── domain
        │   │               │   ├── model
        │   │               │   │   └── BaseEntity.java       // Modelos compartilhados
        │   │               │   └── exception
        │   │               │       └── ResourceNotFoundException.java
        │   │               └── modules
        │   │                   ├── cliente
        │   │                   │   ├── domain
        │   │                   │   │   ├── model
        │   │                   │   │   │   └── Cliente.java
        │   │                   │   │   └── repository
        │   │                   │   │       └── ClienteRepository.java   // Interface do repositório
        │   │                   │   ├── application
        │   │                   │   │   └── usecase
        │   │                   │   │       └── BuscarClientePorIdUseCase.java
        │   │                   │   └── adapter
        │   │                   │       ├── controller
        │   │                   │       │   └── ClienteController.java    // Controlador REST
        │   │                   │       └── persistence
        │   │                   │           ├── entity
        │   │                   │           │   └── ClienteEntity.java    // Mapeamento JPA
        │   │                   │           └── repository
        │   │                   │               └── ClienteRepositoryImpl.java   // Implementação com Spring Data JPA
        │   │                   ├── livro
        │   │                   │   ├── domain
        │   │                   │   │   ├── model
        │   │                   │   │   │   └── Livro.java
        │   │                   │   │   └── repository
        │   │                   │   │       └── LivroRepository.java
        │   │                   │   ├── application
        │   │                   │   │   └── usecase
        │   │                   │   │       └── BuscarLivroPorIdUseCase.java
        │   │                   │   └── adapter
        │   │                   │       ├── controller
        │   │                   │       │   └── LivroController.java
        │   │                   │       └── persistence
        │   │                   │           ├── entity
        │   │                   │           │   └── LivroEntity.java
        │   │                   │           └── repository
        │   │                   │               └── LivroRepositoryImpl.java
        │   │                   └── vendas
        │   │                       ├── domain
        │   │                       │   └── model
        │   │                       │       └── Compra.java     // Agrega Cliente e Livro
        │   │                       ├── application
        │   │                       │   └── usecase
        │   │                       │       └── CriarCompra.java  // Casos de uso para criar compra
        │   │                       └── adapter
        │   │                           └── controller
        │   │                               └── CompraController.java  // Controlador REST para compras
        │   └── resources
        │       ├── application.properties
        │       └── data.sql
        └── test
            └── java
                └── com
                    └── ghdpreto
                        └── apilivraria
                            └── modules
                                └── cliente
                                    └── ClienteControllerTest.java