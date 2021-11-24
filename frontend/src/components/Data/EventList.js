import React, {Component} from "react";
import { Row, Col } from "reactstrap";
import EventListDetails from "./EventListDetails";

import authHeader from "services/auth-header";
import UserService from "services/user.service";

class EventList extends Component {

    constructor(props) {
        super(props);
    
        this.state = {
          events: []
        };
      }
    

    // state = {
    //     events: []
    // }

    getAllEvents() {
        fetch('/event/all', { headers: authHeader() })
            .then(res => res.json())
            .then(json => {
                this.setState({
                    events: json})
                });
    }

    componentDidMount() {
        this.getAllEvents()

        // UserService.getAllEvents().then(
        //     response => {
        //       this.setState({
        //         events: response.data
        //       });
        //     },
        //     error => {
        //       this.setState({
        //         events:
        //           (error.response && error.response.data) ||
        //           error.message ||
        //           error.toString()
        //       });
        //     }
        //   );
        }
      
    

    render() {
        return (            
            <div style={{marginTop: "1.9em"}}>    
                <Row>
                    {this.state.events.map( (event, index) => 
                    <EventListDetails key={index} event={event}/>)}
                </Row>   
            </div>
        )
    }
}

export default EventList