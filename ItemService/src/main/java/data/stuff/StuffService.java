package data.stuff;

import data.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuffService
{
    private StuffDAO staffDAO;

    @Autowired
    public StuffService(StuffDAO staffDAO){
        this.staffDAO = staffDAO;
    }

    @Nullable
    public List<Staff> findALl() {
        return staffDAO.findAll();
    }

    @Nullable
    public List<Staff> findStaffByID(int id) {
        return staffDAO.findStaffByID(id);
    }
}
