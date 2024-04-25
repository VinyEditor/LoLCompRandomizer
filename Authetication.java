@Component
public class AuthenticationEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        Authentication authentication = event.getAuthentication();
        // Verifica se a autenticação foi bem-sucedida e realiza ações de autorização conforme necessário
        // Você pode acessar os detalhes da autenticação, como nome de usuário, autoridades, etc.
        // Por exemplo, você pode registrar o login bem-sucedido, emitir tokens JWT, definir cookies, etc.
    }
}