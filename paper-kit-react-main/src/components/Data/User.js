import React, {Component} from "react";
import UserDetails from "components/Data/UserDetails";

class User extends Component {

    state = {
        users: []
    }

    getAllUser() {
        fetch('/user/all')
            .then(res => res.json())
            .then(json => {
                this.setState({
                    users: json})
                });
    }

    componentDidMount() {
        this.getAllUser()
    }

    render() {
        return (
            <div className="container">
                {this.state.users.map( (user, index) => 
                <UserDetails key={index} user={user}/>)}
            </div>
                )
    }
}

export default User