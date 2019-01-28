package data.IdentityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import data.Token;
import data.User;

@Controller
public class IdentityController
{
    @RequestMapping(value ="/identify", method = RequestMethod.POST)
    @ResponseBody
    public Token getToken(@RequestBody User auth){
        return identityService.getToken(auth);
    }

    @Autowired
    private IdentityService identityService;
}