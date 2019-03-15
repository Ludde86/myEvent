package util;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author Ludde
 * 
 * denna klass hämtar en instans av Date och konverterar den till LocalDate
 * detta för att jag ej kunde spara ett event med LocalDate till databasen
 * 
 */
@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date>{

    @Override
    public Date convertToDatabaseColumn(LocalDate attribute) {
        return (attribute == null ? null : Date.valueOf(attribute));
    }

    @Override
    public LocalDate convertToEntityAttribute(Date dbData) {
        return (dbData == null ? null : dbData.toLocalDate());
    }
    
}
