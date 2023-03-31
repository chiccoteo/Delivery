package star.uz.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import star.uz.delivery.entity.AttachmentContent;

import java.util.Optional;
import java.util.UUID;

public interface AttachmentContentRepo extends JpaRepository<AttachmentContent, UUID> {
    Optional<AttachmentContent> findByAttachmentId(UUID id);
}
