package pe.edu.cibertec.proyectocurso.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.proyectocurso.dao.UsuarioDao;
import pe.edu.cibertec.proyectocurso.model.Usuario;
import pe.edu.cibertec.proyectocurso.service.UsuarioService;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    
    /*
    @Transactional(readOnly = true)
    @Override
    public List<Usuario> listarUsuario() {
        return usuarioDao.listarUsuario();
    }
    */
    
    @Transactional(readOnly = true)
    @Override
    public Usuario obtenerUsuario(Usuario objUsuario){
        return usuarioDao.obtenerUsuario(objUsuario);
    }
    
    
}
