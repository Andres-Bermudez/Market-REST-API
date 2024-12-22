package com.platzi.Market.persistence.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.platzi.Market.exceptions.ValidationException;
import com.platzi.Market.persistence.entities.CustomerEntity;
import com.platzi.Market.persistence.entities.PurchaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import com.platzi.Market.domain.dto.purchasedto.PurchaseSavedDTO;
import com.platzi.Market.domain.dto.purchasedto.PurchaseReceivedDTO;
import com.platzi.Market.persistence.repositories.CustomerRepository;
import com.platzi.Market.persistence.repositories.PurchaseRepository;
import com.platzi.Market.persistence.methods.MethodsPurchasePersistence;

@Service
public class PurchasePersistenceService implements MethodsPurchasePersistence {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<PurchaseSavedDTO> getAllPurchases() {
        return purchaseRepository.findAll().stream()
                                           .map(PurchaseSavedDTO::new)
                                           .toList();
    }

    @Override
    public List<PurchaseSavedDTO> getPurchasesByIdCustomer(String idCustomer) {
        if (!purchaseRepository.existsByIdCustomer(idCustomer)) {
            throw new ValidationException("The id: '" + idCustomer + "' does not exists.");
        }
        return purchaseRepository.getPurchasesByIdCustomer(idCustomer).stream()
                                            .map(PurchaseSavedDTO::new)
                                            .toList();
    }

    @Override
    public PurchaseSavedDTO getPurchaseById(Long idPurchase) {
        if (!purchaseRepository.existsById(idPurchase)) {
            throw new ValidationException("The id: '" + idPurchase + "' does not exists.");
        }
        return new PurchaseSavedDTO(purchaseRepository.getReferenceById(idPurchase));
    }

    @Override
    public PurchaseSavedDTO savePurchase(PurchaseReceivedDTO purchaseReceivedDTO) {

        CustomerEntity customerEntity = new CustomerEntity(
                purchaseReceivedDTO.idCustomer(),
                purchaseReceivedDTO.nameCustomer(),
                purchaseReceivedDTO.lastnameCustomer(),
                purchaseReceivedDTO.phoneCustomer(),
                purchaseReceivedDTO.addressCustomer(),
                purchaseReceivedDTO.emailCustomer()
        );
        CustomerEntity customerSaved = customerRepository.save(customerEntity);

        PurchaseEntity purchaseEntity = new PurchaseEntity(
                customerSaved.getIdCustomer(),
                purchaseReceivedDTO.productsList(),
                purchaseReceivedDTO.total(),
                purchaseReceivedDTO.paymentMethod()
        );
        return new PurchaseSavedDTO(purchaseRepository.save(purchaseEntity));
    }

    @Override
    public void deletePurchase(Long idPurchase) {
        if (!purchaseRepository.existsById(idPurchase)) {
            throw new ValidationException("The id: '" + idPurchase + "' does not exists.");
        }
        purchaseRepository.deleteById(idPurchase);
    }
}
