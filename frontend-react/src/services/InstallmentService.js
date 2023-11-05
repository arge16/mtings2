import axios from 'axios';

const INSTALLMENT_API_URL = "http://localhost:8080/cuotas";

class InstallmentService {

    getInstallments(rut){
        return axios.get(INSTALLMENT_API_URL+ '/bystudent/' + rut);
    }

    createContado(rut){
        return axios.post(INSTALLMENT_API_URL + '/generar-contado/' + rut);
    }

    markPaid(id){
        return axios.get(INSTALLMENT_API_URL + '/mark-paid/' + id);
    }

}

export default new InstallmentService()