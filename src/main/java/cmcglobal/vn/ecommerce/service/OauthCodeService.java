package cmcglobal.vn.ecommerce.service;

import cmcglobal.vn.ecommerce.dto.OauthCodeDTO;
import cmcglobal.vn.ecommerce.entity.OauthCodeEntity;
import cmcglobal.vn.ecommerce.repository.OauthCodeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OauthCodeService {
    public final OauthCodeRepository oauthCodeRepository;

    public OauthCodeService(OauthCodeRepository oauthCodeRepository) {
        this.oauthCodeRepository = oauthCodeRepository;
    }
    public OauthCodeDTO findOauthCode(String code) {
        Optional<OauthCodeEntity> oauthCodeEntityOptional = oauthCodeRepository.findOauthCode(code);
        OauthCodeDTO oauthCodeDTO = new OauthCodeDTO();
        if (oauthCodeEntityOptional.isPresent()) {
            oauthCodeDTO.setCode(oauthCodeEntityOptional.get().getCode());
            oauthCodeDTO.setAuthentication(oauthCodeEntityOptional.get().getAuthentication());
        }
        return oauthCodeDTO;
    }
    public OauthCodeEntity createOauthCode(OauthCodeDTO oauthCodeDTO) {
        OauthCodeEntity oauthCodeEntity = new OauthCodeEntity();
        oauthCodeEntity.setCode(oauthCodeDTO.getCode());
        oauthCodeEntity.setAuthentication(oauthCodeDTO.getAuthentication());
        return oauthCodeRepository.save(oauthCodeEntity);
    }
    public void updateOauthCode(String code, OauthCodeDTO oauthCodeDTO) {
        Optional<OauthCodeEntity> oauthCodeEntityOptional = oauthCodeRepository.findOauthCode(code);
        if (oauthCodeEntityOptional.isPresent()) {
            OauthCodeEntity oauthCodeEntity = oauthCodeEntityOptional.get();
            oauthCodeEntity.setCode(oauthCodeDTO.getCode());
            oauthCodeEntity.setAuthentication(oauthCodeDTO.getAuthentication());
            oauthCodeRepository.save(oauthCodeEntity);
        }
    }

    @Transactional
    public void deleteOauthCode(String code) {
        oauthCodeRepository.delete(code);
    }

    public List<OauthCodeDTO> filterOauthCode(String code, int pageNumber, int pageSize) {
        Pageable paging = PageRequest.of(pageNumber, pageSize);
        Page<OauthCodeEntity> oauthCodeEntities = oauthCodeRepository.findByCodeIsContaining(code, paging);
        List<OauthCodeDTO> oauthCodeDTOList = new ArrayList<>();
        List<OauthCodeEntity> oauthCodeEntityList = oauthCodeEntities.getContent();
        oauthCodeEntityList.forEach(oauthCodeEntity -> {
            OauthCodeDTO oauthCodeDTO = new OauthCodeDTO();
            oauthCodeDTO.setCode(oauthCodeEntity.getCode());
            oauthCodeDTO.setAuthentication(oauthCodeEntity.getAuthentication());
            oauthCodeDTOList.add(oauthCodeDTO);
        });
        return oauthCodeDTOList;
    }


}
