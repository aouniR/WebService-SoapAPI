package com.tekup.soapService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.tekup.xml.eshop.AddItemRequest;
import com.tekup.xml.eshop.AddItemResponse;
import com.tekup.xml.eshop.DeleteItemRequest;
import com.tekup.xml.eshop.DeleteItemResponse;
import com.tekup.xml.eshop.ItemDetailsRequest;
import com.tekup.xml.eshop.ItemDetailsResponse;

@Endpoint
public class ItemEndpoint {
    private static final String NAMESPACE_URI = "http://www.tekup.com/xml/eshop";
    private ItemRepository ItemRepository;

    @Autowired
    public ItemEndpoint(ItemRepository ItemRepository) {
        this.ItemRepository = ItemRepository;
    }

    @PostMapping("/service/item-details")
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ItemDetailsRequest")
    @ResponsePayload
    public ItemDetailsResponse getItem(@RequestPayload ItemDetailsRequest request) {
        ItemDetailsResponse response = new ItemDetailsResponse();
        response.setItem(ItemRepository.findItem(request.getId()));
        return response;
    }

    @PostMapping("/service/add-item")
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddItemRequest")
    @ResponsePayload
    public AddItemResponse getItem(@RequestPayload AddItemRequest request) {
        AddItemResponse response = new AddItemResponse();
        response.setResult(ItemRepository.AddItem(request.getId(), request.getDescription(), request.getPrice()));
        return response;
    }

    @PostMapping("/service/delete-item")
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteItemRequest")
    @ResponsePayload
    public DeleteItemResponse getItem(@RequestPayload DeleteItemRequest request) {
        DeleteItemResponse response = new DeleteItemResponse();
        response.setResult(ItemRepository.DeleteItem(request.getId()));
        return response;
    }
}
