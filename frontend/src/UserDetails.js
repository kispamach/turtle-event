import React, {Component} from "react";

class UserDetails extends Component {
 

    render() {
        return(
            <div className="card card-profile">
                <p className="btn-round mr-1 btn-lg btn btn-outline-primary">{this.props.user.userName}</p>
                <p className="btn-round mr-1 btn-lg btn btn-outline-primary">{this.props.user.firstName} {this.props.user.lastName}</p>
                <p className="btn-round mr-1 btn-lg btn btn-outline-primary">{this.props.user.email}</p>
            </div>
        )
    }
}

export default UserDetails