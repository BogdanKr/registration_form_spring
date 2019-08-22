package ua.registration_form.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ua.registration_form.dto.MessageDto;
import ua.registration_form.entity.Message;
import ua.registration_form.entity.User;

import java.util.List;


public interface MessageRepository extends CrudRepository<Message, Long> {
    @Query("select new ua.registration_form.dto.MessageDto(" +
            "   m, " +
            "   count(ml), " +
            "   sum(case when ml = :user then 1 else 0 end) > 0" +
            ") " +
            "from Message m left join m.likes ml " +
            "group by m")
    List<MessageDto> findAll(@Param("user") User user);

    @Query("select new ua.registration_form.dto.MessageDto(" +
            "   m, " +
            "   count(ml), " +
            "   sum(case when ml = :user then 1 else 0 end) > 0" +
            ") " +
            "from Message m left join m.likes ml " +
            "where m.auth = :auth " +
            "group by m")
    List<MessageDto> findByUser( @Param("auth") User author, @Param("user") User user);

}
