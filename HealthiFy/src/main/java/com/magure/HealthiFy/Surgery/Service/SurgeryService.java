package com.magure.HealthiFy.Surgery.Service;

import com.magure.HealthiFy.Surgery.Data.Request.SurgeryRequest;
import com.magure.HealthiFy.Surgery.Data.Response.SurgeryResponse;
import com.magure.HealthiFy.Surgery.Data.Surgery;
import com.magure.HealthiFy.Surgery.Data.SurgeryStatus;
import com.magure.HealthiFy.Surgery.Repository.SurgeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class SurgeryService {

    @Autowired
    private SurgeryRepository surgeryRepository;

    @Secured("ROLE_PATIENT")
    public SurgeryResponse createSurgery(SurgeryRequest request) {
        Surgery surgery = new Surgery();
        surgery.setPatient(request.getPatient());
        surgery.setName(request.getName());
        surgery.setDescription(request.getDescription());
        surgery.setSurgeryDate(request.getSurgeryDate());
        surgery.setSurgeryStatus(SurgeryStatus.PENDING);
        surgery.setCreatedDate(new Date());
        surgery.setUpdatedDate(new Date());

        Surgery savedSurgery = surgeryRepository.save(surgery);
        return new SurgeryResponse(savedSurgery);
    }

    @Secured("ROLE_PROVIDER") // Assuming only Providers can update status
    public SurgeryResponse updateSurgeryStatus(String id, SurgeryStatus status) {
        Surgery surgery = surgeryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Surgery not found with id: " + id));

        if (status == SurgeryStatus.ACTIVE) {
            // Check if the current status is PENDING
            if (surgery.getSurgeryStatus() == SurgeryStatus.PENDING) {
                surgery.setSurgeryStatus(status);
                surgery.setUpdatedDate(new Date());
                Surgery updatedSurgery = surgeryRepository.save(surgery);
                return new SurgeryResponse(updatedSurgery);
            } else {
                throw new RuntimeException("Surgery status can only be set to ACTIVE from PENDING");
            }
        } else {
            throw new RuntimeException("Invalid status update request");
        }
    }

    public SurgeryResponse getSurgeryById(String id) {
        Surgery surgery = surgeryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Surgery not found with id: " + id));
        return new SurgeryResponse(surgery);
    }

    public void deleteSurgery(String id) {
        Surgery surgery = surgeryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Surgery not found with id: " + id));
        surgeryRepository.delete(surgery);
    }
}
