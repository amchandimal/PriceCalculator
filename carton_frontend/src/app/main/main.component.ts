import { Component, OnInit } from '@angular/core';
import { RestService } from '../_services/rest.service';
import { ProductDto } from '../_models/ProductDto';
import { PricingResponse } from '../_models/PricingReponse';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {

  products:ProductDto[] = [];
  selectedProduct:ProductDto;
  priceMap: PricingResponse[];

  constructor(private restService:RestService) { }

  ngOnInit(): void {
    this.getProductList();
  }

  getProductList(){
    this.restService.getAllProducts().subscribe(prod=>{
        this.products = prod;
        this.selectedProduct = this.products[0];
        this.getProductPrices();
    });
    
  }

  getProductPrices(){
      this.restService.getPriceListforProduct(this.selectedProduct.id).subscribe(prices=>{
        this.priceMap = prices;
      });
  }



}
