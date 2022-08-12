import { Component, OnInit } from '@angular/core';
import { persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';
import { PortfolioService } from 'src/app/service/portfolio.service';

@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit {
  /* miPortfolio:any;
  constructor(private datosPortfolio:PortfolioService) { } */

  persona: persona = new persona("", "", "");
  constructor (public personaService:PersonaService) {}

  ngOnInit(): void {
 /*   this.datosPortfolio.obtenerDatos().subscribe(data => {
      console.log(data);
      this.miPortfolio=data;
    }); */

    this.personaService.getPersona().subscribe(data => {this.persona = data})
  }

}
