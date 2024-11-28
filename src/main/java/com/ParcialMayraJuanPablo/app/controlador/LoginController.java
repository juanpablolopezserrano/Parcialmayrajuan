package com.ParcialMayraJuanPablo.app.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ParcialMayraJuanPablo.app.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String showLogin() {
        return "Login"; // Nombre de la página del formulario de inicio de sesión
    }

    @PostMapping("/login")
    public String handleLogin(
            @RequestParam("usuario") String usuario,
            @RequestParam("contraseña") String contrasena,
            Model model) {
        // Validar el usuario a través del servicio
        String rol = loginService.validarUsuario(usuario, contrasena);

        // Redirigir según el rol
        switch (rol) {
            case "cliente":
                return "redirect:/cliente"; // Redirige a la página del cliente
            case "admin":
                return "redirect:/admin"; // Redirige a la página del administrador
            case "cajero":
                return "redirect:/cajeroPage"; // Redirige a la página del cajero
            case "contador":
                return "redirect:/contador"; // Redirige a la página del contador
            default:
                // Usuario inválido: regresar al login con mensaje de error
                model.addAttribute("error", "Usuario o contraseña incorrectos.");
                return "Login";
        }
    }
}
