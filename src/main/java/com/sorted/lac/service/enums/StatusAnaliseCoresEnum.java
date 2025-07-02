package com.sorted.lac.service.enums;

/**
 * @author Paulo Cesar - BRD
 * @since  21/05/2014
 *
 * */
public enum StatusAnaliseCoresEnum {

    /**
     * Classe responsável por disponibilizar as cores para setar os atributos style
     * das linhas e colunas da tabela Analise em analise.jsp
     *
     * ("COR DE FUNDO", "COR DA FONTE", "ESTILO DA FONTE", "ESPESSURA DA FONTE")
     *
     * */

    EM_DIA     ("", "", "",""),          //Branco ********************  - Cod. 01
    ATRASADO   ("#FF6666", "", "", ""),  //#FF6666 Vermelho - ATRASADO  - Cod. 02
    /*
    CONCLUIDO  ("", "#66FF99", "", ""),  //#66FF99 Verde    - CONCLUIDO - Cod. 03
    SUSPENSO   ("", "#U96HYM", "", ""),  //#U96HYM Amarelo  - SUSPENSO  - Cod. 04
    CANCELADO  ("", "#33CCFF", "", "");  //#33CCFF Azul     - CANCELADO - Cod. 05
    */
    VENCIDO    ("", "#FF6666", "", "bold");  //#FF6666 Vermelho - VENCIDO   - Cod. 06

    private String corDeFundo;
    private String corDaFonte;
    private String estiloDaFonte;
    private String espessuraDaFonte;

    StatusAnaliseCoresEnum(String corDeFundo, String corDaFonte, String estiloDaFonte, String espessuraDaFonte) {
        this.corDeFundo = corDeFundo;
        this.corDaFonte = corDaFonte;
        this.estiloDaFonte = estiloDaFonte;
        this.espessuraDaFonte = espessuraDaFonte;
    }

    public String getCorDeFundo() {
        return corDeFundo;
    }

    public String getCorDaFonte() {
        return corDaFonte;
    }

    public String getEstiloDaFonte() {
        return estiloDaFonte;
    }

    public String getEspessuraDaFonte() {
        return espessuraDaFonte;
    }

}
