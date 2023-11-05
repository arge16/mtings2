import React, { Component } from 'react'
import StudentService from '../services/StudentService'

class ListStudentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            students: []
        }
        this.addStudent = this.addStudent.bind(this);
        this.viewInstallments = this.viewInstallments.bind(this);
    }

    addStudent(){
        this.props.history.push('/add-student');
    }

    viewStudent(id){
        this.props.history.push('/view-student/' + id);
    }

    updateStudent(id){
        alert("Updating a Book is still under construction...");
    }

    deleteStudent(id){
        alert("Deleting a Book is still under construction...");
    }

    viewInstallments(rut){
        this.props.history.push('/view-installments/' + rut);
    }

    componentDidMount(){
        StudentService.getStudents().then((res) => {
            this.setState({ students: res.data});
        });
    }

    render() {
        return (
            <div>
                <br></br>
                 <h2 className="text-center">Estudiantes</h2>
                 <div className = "row">
                    <button className="btn btn-info" onClick={this.addStudent}>Add Student</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Nombre</th>
                                    <th> Apellido</th>
                                    <th> Rut</th>
                                    <th> Año egreso</th>
                                    <th> Colegio</th>
                                    <th> Tipo Colegio</th>
                                    <th> Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.students.map(
                                        student => 
                                        <tr key = {student.id}>
                                             <td> {student.name} </td>   
                                             <td> {student.lastname}</td>
                                             <td> {student.rut}</td>
                                             <td> {student.graduation_year} </td>   
                                             <td> {student.school}</td>
                                             <td> {student.school_type}</td>
                                             <td>
                                                 <button onClick={ () => this.viewInstallments(student.rut)} className="btn btn-info">View Cuotas</button>
                                                 <button onClick={ () => this.viewStudent(student.id)} className="btn btn-info">View</button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.updateStudent(student.id)} className="btn btn-info">Update</button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteStudent(student.id)} className="btn btn-danger">Delete</button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListStudentComponent
