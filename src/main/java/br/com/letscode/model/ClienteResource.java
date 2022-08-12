package br.com.letscode.model;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

@Path("/cliente")
@Produces(MediaType.APPLICATION_JSON)
@Transactional
@ApplicationScoped
public class ClienteResource {
    

    ClienteRepository clienteRepository; // injeção de dependencias

    @Inject
    public ClienteResource(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @GET({ "/list" })
    public List<ClienteDto> lista() {
        List<Cliente> clientes = clienteRepository.list();
        return ClienteDto.converter(clientes);

    }

    // @PUT("/{id}")
    // public void alteraDados(@PathVariable Long id, @RequestBody ClienteForm form) {
    //     Optional<Cliente> optional = Cliente.findByIdentificador(id);
    //     if(optional.isPresent()){
    //     Cliente cliente = form.alterarDados(id, clienteRepository);
        
    
    // }

    // o clientForm é pra pegar no corpo da requisição e não da url
   
    // @POST(" ") 
    // public Cliente cadastrar(String vatnumber,String nome,String email,int idade) {
    //     Cliente entity = new Cliente();
    //     entity.setNome(nome);
    //     entity.setIdade(idade);
    //     entity.setVatnumber(vatnumber);
    //     entity.setEmail(email);
    //     clienteRepository.persist(entity);

    // }

    @DELETE("/{id}")
    public void deletar(@PathParam Long id) {
        clienteRepository.deleteById(id);
    }

}