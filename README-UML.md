### Visitar el sitio web

https://www.plantuml.com/plantuml/uml/SyfFKj2rKt3CoKnELR1Io4ZDoSa700003

### Diagrama de secuencia
```
@startuml
actor User
participant "User Controller" as UC
participant "User Manager" as US
participant "User Factory" as UF
participant "User Repository" as UR
participant "JwtUtil" as JWTG

User -> UC: Registrar usuario
activate UC
UC -> US: create(userData)
activate US
US -> UF: createUser(userData)
activate UF
UF -> JWTG: generateToken(savedUser)
activate JWTG
JWTG -> UF: return token
UF -> US: return userCreado
deactivate JWTG
deactivate UF
US -> UR: save(userData)
activate UR
UR -> UR: Validate and Persist User
UR -> US: return savedUser
deactivate UR
US -> UC: return userData with token
deactivate US
UC -> User: Respond with user data and token
deactivate UC
@enduml
```

### Diagrama de despliegue Docker
```
@startuml
node "Docker Host" {
    component "Docker" {
        artifact "UserAPI Image" as UserAPI
    }

    database "User Database H2" as DB

    component "Spring Boot Application" {
        artifact "UserAPI Jar" as UserAPI_JAR
    }
}

node "Client Machine" {
    [User Interface: Openapi] as UI
}

UI --> UserAPI : HTTP Requests
UserAPI --> UserAPI_JAR : Runs with JDK 21
UserAPI --> DB : Driver H2
@enduml
```

### Diagrama de actividades
```
@startuml
start
:Registrar usuario;
:Enviar información;
if (Valid?) then (yes)
    :Create User;
    :Generate JWT;
    :Return User and Token;
else (no)
    :Return Error;
endif
stop
@enduml
```

### Diagrama de componentes
```
@startuml
package "User API" {
    [User Controller] 
    [User Service]
    [User Repository]
    [User Factory]
    [JWT Generator]
}

package "Database" {
    [User Database]
}

[User Controller] --> [User Service]
[User Service] --> [User Repository]
[User Repository] --> [User Database]
[User Service] --> [User Factory]
[User Factory] --> [JWT Generator]
@enduml
```



