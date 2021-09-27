import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { RestService } from '../_services/rest.service';
import { ProductDto } from '../_models/ProductDto';
import { PricingResponse } from '../_models/PricingReponse';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.scss']
})
export class CalculatorComponent implements OnInit {

  products:ProductDto[] = [];
  cartons = 0;
  units = 0;
  priceResponse: PricingResponse = null;

  constructor(private restService:RestService) { }

  ngOnInit(): void {
    this.getProductList();
  }

  getProductList(){
    this.restService.getAllProducts().subscribe(prod=>{
        this.products = prod;
    });
    
  }

  onSubmit(f:NgForm){
    let prod = f.value.prod;

    if(prod==""){
      alert("Please select a Product");
      return;
    }

    if(this.cartons==null || this.cartons<0){
      alert("Number of Cartons is invalid");
      return;
    }

    if(this.units==null || this.units<0){
      alert("Number of Units is invalid");
      return;
    }

    if(this.units==0 && this.cartons==0){
      alert("Either cartons or units should be greater than 0");
      return;
    }

    let params={
      productid:prod,
      cartons: this.cartons,
      units:this.units
    }

    this.restService.getPriceForProduct(params).subscribe(
      res=>{this.priceResponse = res;},
      err=>{ alert("Error Occured");})  

  }
}
