import { Component, OnInit } from '@angular/core';
import { PortfolioService } from 'src/app/service/portfolio.service';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {
  habilidadesDurasList:any;
  habilidadesBlandasList:any;

  constructor(private datosPortfolio:PortfolioService) { }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatos().subscribe(data => {
      console.log(data);
      this.habilidadesDurasList = data.skillsHard;
    });
    this.datosPortfolio.obtenerDatos().subscribe(data => {
      console.log(data);
      this.habilidadesBlandasList = data.skillsSoft;
    });
  }

}
