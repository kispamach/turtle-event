import React, {Component} from "react";

// reactstrap components
import {
    Button,
    Label,
    FormGroup,
    Input,
    NavItem,
    NavLink,
    Nav,
    TabContent,
    TabPane,
    Container,
    Row,
    Col,
  } from "reactstrap";

  class FollowerDetails extends Component { 

    render() {
        return(
            <><li>
                <Row>
                    <Col className="ml-auto mr-auto" lg="2" md="4" xs="4">
                        <img
                            alt="..."
                            className="img-circle img-no-padding img-responsive"
                            src={require("assets/img/faces/default-face.jpg")
                                .default} />
                    </Col>
                    <Col className="ml-auto mr-auto" lg="7" md="4" xs="4">
                        <h6>
                            {this.props.user && this.props.user.userName} <br />
                            <small>{this.props.user.firstName} {this.props.user.lastName}</small>
                        </h6>
                    </Col>
                    <Col className="ml-auto mr-auto" lg="3" md="4" xs="4">
                        <FormGroup check>
                            <Label check>
                                <Input
                                    defaultChecked
                                    defaultValue=""
                                    type="checkbox" />
                                <span className="form-check-sign" />
                            </Label>
                        </FormGroup>
                    </Col>
                </Row>
            </li>
            {this.props.index + 1 < this.props.fSize ?
            <hr /> :
            <></>}
            </>
        )
    }
  }


  export default FollowerDetails
