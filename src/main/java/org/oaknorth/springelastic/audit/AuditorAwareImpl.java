package org.oaknorth.platform.loan.audit;

import java.util.Optional;
import org.oaknorth.platform.loan.internal.util.SecurityUtil;
import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {
  @Override
  public Optional<String> getCurrentAuditor() {
    return Optional.of(SecurityUtil.getAuthorId());
  }
}
