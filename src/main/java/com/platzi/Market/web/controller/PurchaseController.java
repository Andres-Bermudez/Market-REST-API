package com.platzi.Market.web.controller;

import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.platzi.Market.domain.dto.purchasedto.PurchaseSavedDTO;
import com.platzi.Market.domain.dto.purchasedto.PurchaseReceivedDTO;
import com.platzi.Market.domain.servicesdomain.PurchaseDomainService;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseDomainService purchaseDomainService;

    @GetMapping("/all")
    public ResponseEntity<List<PurchaseSavedDTO>> getAll() {
        return ResponseEntity.ok(purchaseDomainService.getAllPurchases());
    }

    @GetMapping("/findByIdCustomer/{idCustomer}")
    public ResponseEntity<List<PurchaseSavedDTO>> getPurchasesByIdCustomer(
            @PathVariable String idCustomer
    ) {
        return ResponseEntity.ok(purchaseDomainService.getPurchasesByIdCustomer(idCustomer));
    }

    @GetMapping("/{idPurchase}")
    public ResponseEntity<PurchaseSavedDTO> getPurchaseById(
            @PathVariable Long idPurchase
    ) {
        return ResponseEntity.ok(purchaseDomainService.getPurchaseById(idPurchase));
    }

    @PostMapping("/new")
    public ResponseEntity<PurchaseSavedDTO> createPurchase(
            @RequestBody
            PurchaseReceivedDTO purchaseReceivedDTO,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        PurchaseSavedDTO purchaseSavedDTO = purchaseDomainService.savePurchase(purchaseReceivedDTO);

        URI url = uriComponentsBuilder
                .path("/purchases/{idPurchase}")
                .buildAndExpand(purchaseSavedDTO.idPurchase()
                )
                .toUri();
        return ResponseEntity.created(url).body(purchaseSavedDTO);
    }

    @DeleteMapping("/delete/{idPurchase}")
    public ResponseEntity<PurchaseSavedDTO> deletePurchaseById(
            @PathVariable Long idPurchase
    ) {
        purchaseDomainService.deletePurchase(idPurchase);
        return ResponseEntity.ok().build();
    }
}
