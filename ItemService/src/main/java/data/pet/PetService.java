
package data.pet;

import data.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService
{
    @Autowired
    public PetService(PetDAO petDataAccesObject) {
        this.petDAO = petDataAccesObject;
    }

    @Nullable
    public List<Pet> findAll() {
        return petDAO.findAll();
    }

    @Nullable
    public List<Pet> findPetByID(int id) {
        return petDAO.findPetByID(id);
    }

    PetDAO petDAO;
}



