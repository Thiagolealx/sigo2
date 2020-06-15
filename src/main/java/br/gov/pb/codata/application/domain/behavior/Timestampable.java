package br.gov.pb.codata.application.domain.behavior;

import java.time.LocalDateTime;

public interface Timestampable {
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
}
