package repository;

import entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Roomrepository extends JpaRepository<Room, Long> {

}
