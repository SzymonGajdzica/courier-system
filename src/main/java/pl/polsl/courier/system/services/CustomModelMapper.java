package pl.polsl.courier.system.services;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.ejb.Stateful;

@Stateful
public class CustomModelMapper extends ModelMapper {

    public CustomModelMapper() {
        super();
        getConfiguration().setPropertyCondition(Conditions.isNotNull());
        getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

}
