
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    private List<Aluno> lista = new ArrayList<>();

    // Construtor com alguns produtos iniciais
    public AlunoController() {
        lista.add(new Aluno("222222", "João"));
        lista.add(new Aluno("233333", "Lara"));
    }

    // CREATE - POST
    @PostMapping
    public Aluno salvar(@RequestBody Aluno aluno) {
 	    lista.add(aluno);
        return aluno;
    }

    // READ - GET (todos)
    @GetMapping
    public List<Aluno> listar() {
        return lista;
    }

    // READ - GET (por id)
    @GetMapping("/{ra}")
    public Aluno buscarPorRa(@PathVariable String ra) {
        for (Aluno a : lista) {
            if (a.getRa().equals(ra)) {
          	    return a;
            }
        }
        return null;
    }

    // UPDATE - PUT
    @PutMapping("/{ra}")
    public Aluno atualizar(@PathVariable String ra, @RequestBody Produto alunoAtualizado) {
        for (Aluno a : lista) {
            if (a.getRa().equals(ra)) {
                a.setNome(produtoAtualizado.getNome());
                return a;
            }
        }
        return null;
    }

    // DELETE - DELETE
   	@DeleteMapping("/{id}")
    	public String remover(@PathVariable String ra) {
        for (Aluno a : lista) {
            if (p.getRa().equals(ra)) {
                lista.remove(a);
                return "Aluno removido com sucesso";
            }
        }
        return "Aluno não encontrado";
    }

}