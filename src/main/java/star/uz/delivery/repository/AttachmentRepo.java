package star.uz.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import star.uz.delivery.entity.Attachment;

import java.util.UUID;

public interface AttachmentRepo extends JpaRepository<Attachment, UUID> {
}
