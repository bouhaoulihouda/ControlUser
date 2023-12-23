package ma.xproce.demo.web;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import ma.xproce.demo.mappers.UserMapper;
import ma.xproce.demo.services.UserManager;
import ma.xproce.demo.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/graphql")
public class UserGraphQLController {

    private final GraphQL graphQL;

    @Autowired
    public UserGraphQLController(UserManager userManager, UserMapper userMapper) {
        // Initialisation du schéma GraphQL
        GraphQLSchema graphQLSchema = buildGraphQLSchema(userManager, userMapper);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildGraphQLSchema(UserManager userService, UserMapper userMapper) {
        // Ici, vous devrez construire votre schéma GraphQL en utilisant les types, requêtes, mutations, etc.
        // Ceci dépendra de la structure de votre schéma GraphQL et des opérations que vous souhaitez prendre en charge.

        // Exemple de base :
        String schemaDefinition = "type Query { user(id: ID!): User }";
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaDefinition);

        RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
                // Vous devrez ajouter les résolveurs ici pour gérer les requêtes/mutations
                .build();

        GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeRegistry, runtimeWiring);
        return graphQLSchema;
    }

    @PostMapping
    public Object executeGraphQLQuery(@RequestBody String query) {
        // Exécutez la requête GraphQL
        return graphQL.execute(query);
    }

    // Vous pouvez ajouter d'autres méthodes pour gérer d'autres opérations GraphQL
}

