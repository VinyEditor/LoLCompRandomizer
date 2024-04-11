@Controller
public class SocialLoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
