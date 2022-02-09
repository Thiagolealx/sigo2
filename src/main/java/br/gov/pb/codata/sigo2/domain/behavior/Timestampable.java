package br.gov.pb.codata.sigo2.domain.behavior;

import java.time.LocalDateTime;

public interface Timestampable {
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
}
