package com.example.fabrikaline_backend.Repositories;
import com.example.fabrikaline_backend.Entities.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachmentRepository extends JpaRepository<Attachment,Long> {
}
