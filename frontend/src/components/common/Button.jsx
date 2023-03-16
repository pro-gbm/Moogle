/** @jsxImportSource @emotion/react */
import { css } from "@emotion/react";

import { useEffect, useState } from "react";

/////////////// Type
// color: default, disabled, warning
// variant: outlined, filled
// size: small, medium, large
// value: any string
// icon: icon component
// iconPosition: front, back

export default function Button(props) {
  const { color, size, value, variant, iconPosition } = props;
  const Icon = props.icon;

  const [feature, setFeature] = useState({
    text_color: "#FFFFFF",
    border_color: "#FFFFFF",
    bg_color: "#FFFFFF",
    padding: 8,
    height: 25,
    font_size: 22,
    border_radius: 6,
  });

  const buttonStyle = css({
    backgroundColor: feature.bg_color,
    border:
      variant === "outlined" ? `2px solid ${feature.border_color}` : undefined,
    color: feature.text_color,
    padding: `${feature.padding}px`,
    paddingLeft: `calc(${feature.padding}px + 20px)`,
    paddingRight: `calc(${feature.padding}px + 20px)`,
    fontSize: `${feature.font_size}px`,
    borderRadius: `${feature.border_radius}px`,
    height: `${feature.height}px`,
    width: "fit-content",
    whiteSpace: "nowrap",
    fontWeight: "bold",
    cursor: color !== "disabled" ? "pointer" : "default",
    display: "flex",
    alignItems: "center",
    "&:hover": {
      boxShadow:
        color !== "disabled"
          ? "3px 2px 5px rgba(0,0,0,0.15), inset 0 0 100px 100px rgba(255,255,255,0.2)"
          : undefined,
      transition: "box-shadow 0.2s ease-out",
    },
    ".icon-front": {
      paddingRight: "5px",
    },
    ".icon-back": {
      paddingLeft: "5px",
    },
  });

  const parseProps = () => {
    let text_color = "";
    let border_color = "";
    let bg_color = "";
    let padding = 0;
    let height = 0;
    let font_size = 0;
    let border_radius = 0;

    switch (size) {
      case "small":
        padding = 5;
        height = 15;
        font_size = 12;
        border_radius = 3;
        break;
      case "medium":
        padding = 8;
        height = 20;
        font_size = 17;
        border_radius = 4;
        break;
      case "large":
        padding = 12;
        height = 25;
        font_size = 22;
        border_radius = 6;
        break;
      default:
        padding = 12;
        height = 25;
        font_size = 22;
        border_radius = 6;
    }

    switch (variant) {
      case "outlined":
        if (color === "warning") {
          text_color = "#E2202C";
          border_color = "#E2202C";
          bg_color = "#FFFFFF";
        } else if (color === "disabled") {
          text_color = "#D9D9D9";
          border_color = "#D9D9D9";
          bg_color = "#FFFFFF";
        } else {
          text_color = "#ffcb00";
          border_color = "#ffcb00";
          bg_color = "#FFFFFF";
        }
        break;
      case "filled":
        if (color === "warning") {
          text_color = "#FFFFFF";
          border_color = "#E2202C";
          bg_color = "#E2202C";
        } else if (color === "disabled") {
          text_color = "#FFFFFF";
          border_color = "#D9D9D9";
          bg_color = "#D9D9D9";
        } else {
          text_color = "#FFFFFF";
          border_color = "#ffcb00";
          bg_color = "#ffcb00";
        }
        break;
      default:
        text_color = "#FFFFFF";
        border_color = "#FFFFFF";
        bg_color = "#FFFFFF";
    }

    return {
      text_color: text_color,
      border_color: border_color,
      bg_color: bg_color,
      padding: padding,
      height: height,
      font_size: font_size,
      border_radius: border_radius,
    };
  };

  useEffect(() => {
    setFeature({
      ...feature,
      text_color: parseProps().text_color,
      border_color: parseProps().border_color,
      bg_color: parseProps().bg_color,
      padding: parseProps().padding,
      height: parseProps().height,
      font_size: parseProps().font_size,
      border_radius: parseProps().border_radius,
    });
  }, [variant, color, size]);

  return (
    <div className="icon-wrapper" css={buttonStyle}>
      {iconPosition === "front" && Icon && (
        <div className="icon-front">
          <Icon fontSize="small" sx={{ cursor: "inherit" }} />
        </div>
      )}
      {value.toUpperCase()}
      {iconPosition === "back" && Icon && (
        <div className="icon-back">
          <Icon fontSize="small" sx={{ cursor: "inherit" }} />
        </div>
      )}
    </div>
  );
}
