package com.RoieIvri.MyFamilysMealPlanner.FEATURES.MEAL;

import com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY.Family;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.RECIPE.Recipe;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.MealTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ToString
public class Meal  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private int timeToMakeInMinutes; ///TODO : Think about moving this att to a spacial DTo , its the sum of the
    private int numberOfEaters;
    private boolean isActive= true;
    @Enumerated(EnumType.STRING)
    private MealTime mealTime;
    @ManyToMany()
    private List<Recipe> recipeList= new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

@ManyToOne
@JsonIgnore
private Family family;
    public void addRecipe(Recipe recipe){
        this.recipeList.add(recipe);
    }

}
