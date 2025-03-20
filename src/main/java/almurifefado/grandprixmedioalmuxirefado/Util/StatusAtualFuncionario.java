package almurifefado.grandprixmedioalmuxirefado.Util;

public enum StatusAtualFuncionario {
    ATIVO("Este perfil está ativo no sistema"),
    INATIVO("Este perfil está inativo no sistema");

String descrição;
private  StatusAtualFuncionario (){

}
private StatusAtualFuncionario (String descrição){
    this.descrição = descrição;
}
}