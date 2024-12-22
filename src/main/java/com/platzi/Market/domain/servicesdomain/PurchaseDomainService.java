package com.platzi.Market.domain.servicesdomain;

import java.util.List;
import org.springframework.stereotype.Service;
import com.platzi.Market.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import com.platzi.Market.domain.dto.purchasedto.PurchaseSavedDTO;
import com.platzi.Market.domain.dto.purchasedto.PurchaseReceivedDTO;
import com.platzi.Market.persistence.methods.MethodsPurchasePersistence;
import com.platzi.Market.persistence.services.PurchasePersistenceService;

@Service
public class PurchaseDomainService implements MethodsPurchasePersistence {

    @Autowired
    private PurchasePersistenceService purchasePersistenceService;


    @Override
    public List<PurchaseSavedDTO> getAllPurchases() {
        return purchasePersistenceService.getAllPurchases();
    }

    @Override
    public List<PurchaseSavedDTO> getPurchasesByIdCustomer(String idCustomer) {
        if (idCustomer == null) {
            throw new ValidationException("The field idCustomer is null");
        }
        return purchasePersistenceService.getPurchasesByIdCustomer(idCustomer);
    }

    @Override
    public PurchaseSavedDTO getPurchaseById(Long idPurchase) {
        if (idPurchase == null) {
            throw new ValidationException("The field idPurchase is null");
        }
        return purchasePersistenceService.getPurchaseById(idPurchase);
    }

    @Override
    public PurchaseSavedDTO savePurchase(PurchaseReceivedDTO purchaseReceivedDTO) {
        if (purchaseReceivedDTO.nameCustomer() == null || purchaseReceivedDTO.nameCustomer().isEmpty() ||
            purchaseReceivedDTO.lastnameCustomer() == null || purchaseReceivedDTO.lastnameCustomer().isEmpty() ||
            purchaseReceivedDTO.phoneCustomer() == null || purchaseReceivedDTO.phoneCustomer().isEmpty() ||
            purchaseReceivedDTO.addressCustomer() == null || purchaseReceivedDTO.addressCustomer().isEmpty() ||
            purchaseReceivedDTO.emailCustomer() == null || purchaseReceivedDTO.emailCustomer().isEmpty() ||
            purchaseReceivedDTO.productsList() == null || purchaseReceivedDTO.productsList().isEmpty() ||
            purchaseReceivedDTO.total() == null ||
            purchaseReceivedDTO.paymentMethod() == null || purchaseReceivedDTO.paymentMethod().isEmpty()
        ) {
            throw new ValidationException("The fields required is null");
        }
        return purchasePersistenceService.savePurchase(purchaseReceivedDTO);
    }

    @Override
    public void deletePurchase(Long idPurchase) {
        if (idPurchase == null) {
            throw new ValidationException("The field idPurchase is null");
        }
        purchasePersistenceService.deletePurchase(idPurchase);
    }
}
