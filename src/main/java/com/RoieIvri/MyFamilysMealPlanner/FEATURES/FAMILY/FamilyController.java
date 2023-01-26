package com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY;


import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GeneralExceptions;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GodController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/family")
public class FamilyController implements GodController<Family> {

    private final FamilyService familyService;


    @Override
    @PostMapping
    public Family addObject(@RequestBody Family family) throws Exception {
        return familyService.addObject(family);
    }

    @Override
    @PutMapping("/{familyId}")
    public Family updateObject(@RequestBody Family family, @PathVariable Long familyId) throws Exception {
        return familyService.updateObject(family, familyId);
    }

    @Override
    @GetMapping("/all")
    public List<Family> getAll() throws Exception {
        return familyService.getAll();
    }

    @Override
    @GetMapping
    public List<Family> getAllActive() throws Exception {
        return familyService.getAllActive();
    }

    @GetMapping("/id/{familyId}")
    public Family getById(@PathVariable Long familyId) throws GeneralExceptions {

        return familyService.getFullFamilyById(familyId);
    }


    @Override
    @PutMapping("/{objectId}")
    public Family disableObject(@PathVariable Long objectId) throws Exception {
        return familyService.disableObject(objectId);
    }

    @Override
    @DeleteMapping("/{objectId}")
    public void deleteObject(@PathVariable Long objectId) throws Exception {
        familyService.deleteObject(objectId);
    }
}
