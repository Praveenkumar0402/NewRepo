import { Injectable, Output } from "@angular/core";
import { EventEmitter } from "protractor";
import Swal from "sweetalert2";
import * as en_statuscode from "../config/status_code.json";

@Injectable({
  providedIn: "root",
})
export class CommonService {
  constructor() {}

  confirmResult: any;

  // to get common popups
  getPopup = (
    title,
    text,
    confirmationbuttontext = null,
    statuscode,
    iserror = false,
    isconfirmationbox = false
  ) => {
    try {
      return new Promise((resolve, reject) => {
        if (statuscode && statuscode == "undefined") {
          Swal.fire({
            position: "top-right",
            timer: 3500,
            title: "",
            text: "Network error",
            width: "250px",
            toast: true,
            customClass: {
              popup: "swal-errorcontent",
              icon: "swal-icon",
            },
            icon: "error",
            showCancelButton: false,
            showConfirmButton: false,
          });
          resolve(true);
        } else {
          let getStatusCodeText =
            text == null ? en_statuscode["default"][statuscode] : text;
          getStatusCodeText = this.sentenceCase(getStatusCodeText);
          if (isconfirmationbox == false) {
            Swal.fire({
              position: "top-right",
              timer: 3500,
              title: "",
              text: getStatusCodeText,
              width: "250px",
              toast: true,
              customClass: {
                popup: iserror ? "swal-errorcontent" : "swal-content",
                icon: "swal-icon",
              },
              icon:
                iserror == false && statuscode !== "s_1015" ? "info" : "error",
              showCancelButton: false,
              showConfirmButton: false,
            });
            resolve(true);
          } else if (isconfirmationbox == true) {
            Swal.fire({
              position: "center",
              timer: 500000,
              title: "",
              text: text,
              width: "250px",
              toast: false,
              icon:
                iserror == false && statuscode !== "s_1015" ? "info" : "error",
              showCancelButton: true,
              confirmButtonText: confirmationbuttontext,
              cancelButtonText: "Cancel",
              reverseButtons: true,
            }).then((swalResult) => {
              if (swalResult && swalResult.isConfirmed) {
                // return true;
                resolve(true);
              } else {
                resolve(false);
              }
            });
          }
        }
      });
    } catch (error) {}
  };

  // convert to title case
  sentenceCase(str) {
    try {
      if (str === null || str === "") return "";
      else str = str.toString();

      return str.replace(/\w\S*/g, function (txt) {
        return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();
      });
    } catch (error) {}
  }
}
