import React, {Component} from "react";
import { Row, Col } from "reactstrap";
import EventListDetails from "./EventListDetails";

class EventList extends Component {

    state = {
        events: []
    }

    getAllEvents() {
        fetch('/event/all')
            .then(res => res.json())
            .then(json => {
                this.setState({
                    events: json})
                });
    }

    componentDidMount() {
        this.getAllEvents()
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