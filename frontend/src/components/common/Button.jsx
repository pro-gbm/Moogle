import { useEffect, useState } from "react";
import { styled } from "@mui/material/styles";

export default function Button(props) {
  const { color, size, value, variant } = props;
  const Icon = props.icon;

  const IconWrapper = styled("div")(() => ({
    fontWeight: "bold",
    cursor: color !== "disabled" ? "pointer" : "default",
    display: "flex",
    alignItems: "center",
    "&:hover": {
      boxShadow: color !== "disabled" ? "3px 3px 5px #DDD" : undefined,
      transition: "box-shadow 0.2s ease-out",
    },
  }));

  useEffect(() => {
    setFeature({
      ...feature,
      text_color: parseProps().text_color,
      border_color: parseProps().border_color,
      bg_color: parseProps().bg_color,
    });
  }, [variant, color]);

  const parseProps = () => {
    let text_color = "";
    let border_color = "";
    let bg_color = "";
    let padding = 0;
    let font_size = 0;
    let border_radius = 0;

    switch (size) {
      case "small":
        padding = 5;
        font_size = 13;
        border_radius = 20;
        break;
      case "medium":
        padding = 7;
        font_size = 15;
        border_radius = 23;
        break;
      case "large":
        padding = 9;
        font_size = 17;
        border_radius = 25;
        break;
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
          text_color = "#75D1E5";
          border_color = "#75D1E5";
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
          border_color = "#75D1E5";
          bg_color = "#75D1E5";
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
      font_size: font_size,
      border_radius: border_radius,
    };
  };

  const [feature, setFeature] = useState({
    text_color: parseProps().text_color,
    border_color: parseProps().border_color,
    bg_color: parseProps().bg_color,
    padding: parseProps().padding,
    font_size: parseProps().font_size,
    border_radius: parseProps().border_radius,
  });

  return (
    <IconWrapper
      style={{
        backgroundColor: feature.bg_color,
        border: `2px solid ${feature.border_color}`,
        color: feature.text_color,
        padding: `${feature.padding}px`,
        paddingLeft: `calc(${feature.padding}px + 5px)`,
        paddingRight: `calc(${feature.padding}px + 5px)`,
        fontSize: `${feature.font_size}px`,
        borderRadius: `${feature.border_radius}px`,
        width: "fit-content",
        whiteSpace: "nowrap",
      }}
    >
      <Icon fontSize="small" sx={{ paddingRight: "5px", cursor: "inherit" }} />
      {value.toUpperCase()}
    </IconWrapper>
  );
}
