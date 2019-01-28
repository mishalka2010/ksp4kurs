package data.stuff;

import data.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StuffController
{
    @RequestMapping(value = "staff/", method = RequestMethod.GET)
    @ResponseBody
    public List<Staff> findStaffs() {
        return staffService.findALl();
    }

    @RequestMapping(value = "staff/{itemID}", method = RequestMethod.GET)
    @ResponseBody
    public List<Staff> findStaff(@PathVariable int itemID){
        return staffService.findStaffByID(itemID);
    }

    @Autowired
    private StuffService staffService;
}
