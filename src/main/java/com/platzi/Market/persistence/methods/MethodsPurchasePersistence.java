package com.platzi.Market.persistence.methods;

import java.util.List;
import com.platzi.Market.domain.dto.purchasedto.PurchaseSavedDTO;
import com.platzi.Market.domain.dto.purchasedto.PurchaseReceivedDTO;

public interface MethodsPurchasePersistence {

    List<PurchaseSavedDTO> getAllPurchases();
    List<PurchaseSavedDTO> getPurchasesByIdCustomer(String idCustomer);
    PurchaseSavedDTO getPurchaseById(Long idPurchase);
    PurchaseSavedDTO savePurchase(PurchaseReceivedDTO purchaseReceivedDTO);
    void deletePurchase(Long idPurchase);
}
