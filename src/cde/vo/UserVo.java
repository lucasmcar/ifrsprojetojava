package cde.vo;

public class UserVo {
    
    private int idUser;
    private String userName;
    private String password;

    public UserVo() {
    }

    public UserVo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    
    /**
     * Verifica se o campo usuário esá vazio e em branco
     * @param userName
     * @param password
     * @return boolan
     */
    public boolean isValidUser(String userName){
        this.userName = userName;
        if(!this.userName.isEmpty() && !this.userName.isBlank()){
             return true;
        } else {
            return false;
        }
    }
    
    /**
     * Verifica se o campo senha está vazio m branco
     * @param password
     * @return boolean
     */
    public boolean isValidPassword(String password){
        this.password = password;
        if(!this.password.isEmpty() || !this.password.isBlank()){
             return true;
        } else {
            return false;
        }
    }
}
